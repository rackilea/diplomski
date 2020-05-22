List sort = Arrays.asList(new FieldSortBuilder("total_points").order(SortOrder.DESC));
   BucketSortPipelineAggregationBuilder bucketSort = PipelineAggregatorBuilders.bucketSort("test_bucket_sort", sort).from(1).size(3);

   this.aggregationBuilder = AggregationBuilders
            .terms("group_by_user")
            .field("userId.keyword")
            .subAggregation(AggregationBuilders.sum("total_points").field("points"))
            .subAggregation(bucketSort)