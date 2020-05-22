public static <T> T[] CollectionToArray(Collection<T> collection, T[] arr) {

            return collection.stream().toArray(value ->Arrays.copyOf(arr,collection.size()));


        }