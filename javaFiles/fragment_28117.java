public static void split(TopicLinkdata source_sim_arr,
        TopicLinkdata trainingSet_sim_arr, TopicLinkdata testData_sim_arr)
{
    trainingSet_sim_arr.setUrl_id(Arrays.copyOfRange(
            source_sim_arr.getUrl_id(), 0,
            source_sim_arr.getUrl_id().length / 2));
    testData_sim_arr.setUrl_id(Arrays.copyOfRange(
            source_sim_arr.getUrl_id(),
            source_sim_arr.getUrl_id().length / 2,
            source_sim_arr.getUrl_id().length));

    trainingSet_sim_arr.setSum_url_Tsim(Arrays.copyOfRange(
            source_sim_arr.getSum_url_Tsim(), 0,
            source_sim_arr.getSum_url_Tsim().length / 2));
    testData_sim_arr.setSum_url_Tsim(Arrays.copyOfRange(
            source_sim_arr.getSum_url_Tsim(),
            source_sim_arr.getSum_url_Tsim().length / 2,
            source_sim_arr.getSum_url_Tsim().length));
}