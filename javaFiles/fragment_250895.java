public class MSTRevisited {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        /*
         * graph.addNode('a'); graph.addNode('b'); graph.addNode('c');
         * graph.addNode('d'); graph.addNode('e'); graph.addNode('f');
         * graph.addEdege('a', 'b', 4); graph.addEdege('a', 'f', 2);
         * graph.addEdege('b', 'f', 3); graph.addEdege('b', 'c', 6);
         * graph.addEdege('c', 'f', 1); graph.addEdege('c', 'd', 3);
         * graph.addEdege('d', 'e', 2); graph.addEdege('f', 'e', 4);
         */
        graph.addNode('a');
        graph.addNode('b');
        graph.addNode('c');
        graph.addNode('d');
        graph.addEdege('a', 'b', 4);
        graph.addEdege('a', 'c', 2);
        graph.addEdege('b', 'c', 1);
        graph.addEdege('b', 'd', 2);
        graph.addEdege('c', 'd', 3);
        graph.applyPrimAlgo();
    }

    public static class Graph {
        private Vertex verticies[];
        private int maxSize;
        private int size;
        private HashMap map;
        private MinHeap Q;

        public Graph(int maxSize) {
            this.maxSize = maxSize;
            verticies = new Vertex[maxSize];
            map = new HashMap(maxSize);
            Q = new MinHeap(maxSize);
        }

        public void addNode(char data) {
            verticies[size] = new Vertex(data, size);
            map.put(data, size);
            size++;
        }

        public void addEdege(char sourceData, char destinationData, int weight) {
            int sourceIndex = map.get(sourceData);
            int destinationIndex = map.get(destinationData);
            verticies[sourceIndex].adj = new Neighbour(destinationIndex,
                    weight, verticies[sourceIndex].adj);
            verticies[destinationIndex].adj = new Neighbour(sourceIndex,
                    weight, verticies[destinationIndex].adj);
        }

        public void applyPrimAlgo() {
            // add all the keys to the Q

            PrimEdege pe = null;
            Vertex vertex = verticies[0];
            vertex.cost = 0;
            vertex.state = Vertex.IN_Q;
            Q.add(vertex);
            while (!Q.isEmpty()) {
                Vertex poppedVertex = Q.remove();
                poppedVertex.state = Vertex.VISITED;
                Neighbour temp = poppedVertex.adj;
                if (poppedVertex.parentIndex != -1) {
                    char source = verticies[poppedVertex.index].data;
                    char destination = verticies[poppedVertex.parentIndex].data;
                    pe = new PrimEdege(source, destination, pe);
                }
                while (temp != null) {
                    Vertex adjVertex = verticies[temp.index];
                    if (adjVertex.state != Vertex.VISITED) {
                        if (adjVertex.cost > temp.weight) {
                            adjVertex.cost = temp.weight;
                            adjVertex.parentIndex = poppedVertex.index;
                        }
                        if (adjVertex.state != Vertex.IN_Q) {
                            Q.add(adjVertex);
                            adjVertex.state = Vertex.IN_Q;
                        } else {
                            // bubble up this Node in the heap
                            Q.bubbleUp(adjVertex);
                        }
                    }
                    temp = temp.next;
                }
            }

            PrimEdege temp = pe;
            while (temp != null) {
                System.out.print("(" + temp.source + "," + temp.destination
                        + ") ");
                temp = temp.next;
            }
            System.out.println();
        }

        private static class PrimEdege {
            public char source;
            public char destination;
            private PrimEdege next;

            public PrimEdege(char source, char destination, PrimEdege next) {
                this.source = source;
                this.destination = destination;
                this.next = next;
            }
        }

        public static class MinHeap {
            private Vertex[] items;
            private int maxSize;
            private int size;

            public MinHeap(int maxSize) {
                this.maxSize = maxSize;
                items = new Vertex[maxSize];
            }

            public void bubbleUp(Vertex vertex) {
                // @TODO
                int i = 0;
                for (; i < size; i++) {
                    if (items[i] == vertex) {
                        break;
                    }
                }
                if (i < size) {
                    int currentIndex = i;
                    Vertex currentItem = items[currentIndex];
                    int parentIndex = (currentIndex-1) / 2;
                    Vertex parentItem = items[parentIndex];
                    while (currentItem.compareTo(parentItem) == -1) {
                        swap(currentIndex, parentIndex);
                        currentIndex = parentIndex;
                        currentItem = items[currentIndex];
                        parentIndex = (currentIndex-1) / 2;
                        parentItem = items[parentIndex];
                    }
                }
            }

            public void add(Vertex item) {
                items[size] = item;
                heapifyAfterAdd();
                size++;
            }

            private void swap(int index1, int index2) {
                Vertex temp = items[index1];
                items[index1] = items[index2];
                items[index2] = temp;
            }

            private void heapifyAfterAdd() {
                int currIndex = size;
                Vertex currItem = items[currIndex];
                int parentIndex = (currIndex-1) / 2;
                Vertex parentItem = items[parentIndex];
                while (currItem.compareTo(parentItem) == -1) {
                    swap(parentIndex, currIndex);
                    currIndex = parentIndex;
                    currItem = items[currIndex];
                    parentIndex = (currIndex-1) / 2;
                    parentItem = items[parentIndex];
                }
            }

            public Vertex remove() {
                return remove(0);
            }

            public Vertex remove(Vertex vertex) {
                int i = 0;
                for (; i < size; i++) {
                    if (items[i] == vertex) {
                        break;
                    }
                }
                if (i < size) {
                    return remove(i);
                }
                return null;

            }

            private Vertex remove(int index) {
                Vertex vertex = items[index];
                swap(index, size - 1);
                items[size - 1] = null;
                size--;
                heapifyAfterRemove(index);
                return vertex;
            }

            private void heapifyAfterRemove(int index) {
                int currIndex = index;
                Vertex currItem = items[currIndex];
                int childIndex;
                Vertex childItem;
                int left = 2 * currIndex + 1;
                int right = 2 * currIndex + 2;
                if (left > size - 1) {
                    return;
                }
                if (right > size - 1) {
                    childIndex = left;
                } else if (items[left].compareTo(items[right]) == -1) {
                    childIndex = left;
                } else {
                    childIndex = right;
                }
                childItem = items[childIndex];

                while (childItem.compareTo(currItem) == -1) {
                    swap(currIndex, childIndex);
                    currIndex = childIndex;
                    currItem = items[currIndex];
                    left = 2 * currIndex + 1;
                    right = 2 * currIndex + 2;
                    if (left > size - 1) {
                        return;
                    }
                    if (right > size - 1) {
                        childIndex = left;
                    } else if (items[left].compareTo(items[right]) == -1) {
                        childIndex = left;
                    } else {
                        childIndex = right;
                    }
                    childItem = items[childIndex];
                }
            }

            public boolean isEmpty() {
                return size == 0;
            }
        }

        public static class HashMap {
            private MapNode[] map;
            private char[] keySet;
            private int maxSize;
            private int size;

            public HashMap(int maxSize) {
                this.maxSize = maxSize;
                map = new MapNode[maxSize];
                keySet = new char[maxSize];
            }

            private static class MapNode {
                char key;
                int value;
                MapNode next;

                public MapNode(char key, int value, MapNode next) {
                    this.key = key;
                    this.value = value;
                    this.next = next;
                }
            }

            public int hash(char key) {
                return 31 * key;
            }

            public int getmapIndexOfkey(char key) {
                return hash(key) % maxSize;
            }

            public void put(char key, int value) {
                int index = getmapIndexOfkey(key);
                map[index] = new MapNode(key, value, map[index]);
                keySet[index] = key;
                size++;
            }

            public int get(char key) {
                int index = getmapIndexOfkey(key);
                MapNode temp = map[index];
                while (temp != null) {
                    if (temp.key == key) {
                        break;
                    }
                }
                if (temp != null) {
                    return temp.value;
                } else {
                    return -1;
                }
            }

            public char[] keyset() {
                return keySet;
            }
        }

        public static class Vertex {
            public static final int NEW = 0;
            public static final int IN_Q = 1;
            public static final int VISITED = 2;
            private int state = NEW;
            private int cost = Integer.MAX_VALUE;
            private char data;
            private Neighbour adj;
            private int index;
            private int parentIndex = -1;

            public int compareTo(Vertex other) {
                if (cost < other.cost) {
                    return -1;
                }
                if (cost > other.cost) {
                    return 1;
                }
                return 0;
            }

            public Vertex(char data, int index) {
                this.data = data;
                this.index = index;
            }

            public void addAdjacentVertex(Neighbour adj) {
                this.adj = adj;
            }

            public void updateCost(int newCost, int parentIndex) {
                this.cost = newCost;
                this.parentIndex = parentIndex;
            }
        }

        public static class Neighbour {
            private Neighbour next;
            private int index;
            private int weight;

            public Neighbour(int index, int weight, Neighbour next) {
                this.next = next;
                this.index = index;
                this.weight = weight;
            }
        }
    }
}