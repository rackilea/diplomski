final List<IndexInfo> indexes = mongoTemplate.indexOps("myCollection").getIndexInfo();
assertThat(indexes, hasSize(3));
assertThat(indexes, hasItem(hasProperty("name", is("_id_"))));
assertThat(indexes, hasItem(hasProperty("name", is("index1"))));
assertThat(indexes, hasItem(hasProperty("name", is("index2"))));
assertThat(indexes, hasItem(hasProperty("indexFields", hasItem(hasProperty("key", is("field1"))))));