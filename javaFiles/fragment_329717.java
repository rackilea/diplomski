package com.akash.mongo.multidb.repository.amazon;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akash.mongo.multidb.entity.ProductDetails;

/**
 * 
 * @author Akash
 *
 */
@Repository
public interface AmazonRepository extends MongoRepository<ProductDetails, ObjectId> {

}