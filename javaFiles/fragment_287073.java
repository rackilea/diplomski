- (void)loadArticles{
        RKObjectMapping* articleMapping = [RKObjectMapping mappingForClass:[Article class]];
        [articleMapping addAttributeMappingsFromDictionary:@{ 
            @"title": @"title",
            @"body": @"body",
            @"author": @"author",
            @"publication_date": @"publicationDate"
        }];
        RKResponseDescriptor *responseDescriptor = [RKResponseDescriptor responseDescriptorWithMapping:articleMapping pathPattern:nil keyPath:@"articles" statusCodes:RKStatusCodeIndexSetForClass(RKStatusCodeClassSuccessful)];
    NSString * stringURL = @"/articles/";
    [RKObjectManager.sharedManager getObjectsAtPath:stringURL parameters:nil success:^(RKObjectRequestOperation *operation, RKMappingResult *mappingResult){
            RKLogInfo(@"Load collection of Articles: %@", mappingResult.array);
        } failure:^(RKObjectRequestOperation *operation, NSError *error) {
            RKLogError(@"Operation failed with error: %@", error);
        }];

        [objectRequestOperation start];
    }