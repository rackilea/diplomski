@SpringBootTest
@EmbeddedKafka(topics = "foo", partitions = 3)
class So57481979ApplicationTests {

    @Test
    void testPartitions(@Autowired KafkaAdmin admin) throws InterruptedException, ExecutionException {
        AdminClient client = AdminClient.create(admin.getConfig());
        Map<String, TopicDescription> map = client.describeTopics(Collections.singletonList("foo")).all().get();
        System.out.println(map.values().iterator().next().partitions().size());
    }

}