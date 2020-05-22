String[] arr = line.split(" ");
if (arr.length > 3) {
    result.add(new Edge(Integer.parseInt(arr[0]), //index
            getPointbyIndex(PointCollection,Integer.parseInt(arr[1])), //start
            getPointbyIndex(PointCollection,Integer.parseInt(arr[2])), //end
            Integer.parseInt(arr[3]))); //cost
    }
}