while (result.next()) {

    T t = factory.apply(result);

    listDbData.add(t);
}