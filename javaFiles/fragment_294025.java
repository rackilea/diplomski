list
.stream()
.map(s -> s.split(","))
.map(cells -> {
    Put put = new Put(Bytes.toBytes(cells[0]));
    put.addColumn(Bytes.toBytes(cells[1]), Bytes.toBytes(cells[2]), Bytes.toBytes(cells[3]));
    return put;
})
.forEach(System.out::println) // or .collect to list