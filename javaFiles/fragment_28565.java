Map<String, String> map = new HashMap<String, String>();

for ( String actualElement : input.split("&") ) {
    map.put(actualElement.split("=")[0],
            actualElement.split("=")[1]);
}

System.out.println(map);