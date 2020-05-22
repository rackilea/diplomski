package com.akash.mongo.multidb.repository.flipkart;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akash.mongo.multidb.entity.ProductDetails;

@Repository
public interface FlipkartRepository extends MongoRepository<ProductDetails, ObjectId> {

}