/**
 * This method returns a size of the set of nodes by taking a String
 * parameter which the name of the maze file.
 *
 * @param mazeFile - String parameter for reading maze file for scanning the
 * size of the nodes.
 * @return - returns an integer value for the size of the set of nodes.
 * @throws FileNotFoundException if the mazeFile could not be found
 */
public static int getNodeSize(String mazeFile) throws FileNotFoundException{
        scanNodeSize = new Scanner(new File(mazeFile));
        while (scanNodeSize.hasNextInt()) {
            int node1 = scanNodeSize.nextInt();
            int node2 = scanNodeSize.nextInt();
            setOfNodes.add(node1);
            setOfNodes.add(node2);
        }

        //Changes begin here
        Integer max = setOfNodes.stream().reduce(Integer::max).get();
        return max+1;
        //Changes end here

}