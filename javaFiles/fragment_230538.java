class TopicsResponseProcessor implements ProcessResponse<Topics>
    {
        public void process(Topics response)
        {
            createTopicsList(response);
        }

    }

new AcquireResponseTask<Topics>(Topics.class,TopicsResponseProcessor ()).execute(UrlBuilder.getTopics());