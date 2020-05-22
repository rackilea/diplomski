package com.akash.mongo.multidb.service;

import java.util.Map;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.akash.mongo.multidb.entity.ProductDetails;

/**
 * Implementation of ProductDetailsService interface
 * @author Akash
 *
 */
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);

    /*
     * Spring boot will autowire all the repositories along with their name
     * amazonRepository - amazon repository instance
     * ebayRepository - ebay repository instance and so on
     */
    @Autowired
    Map<String, MongoRepository<ProductDetails, ObjectId>> repositories;

    @Override
    public void addProductDetails(String productOrigin, ProductDetails productDetails) throws RuntimeException {

        logger.info("Adding product details into {} db", productOrigin);

        //if productOrigin is Amazon; repositoryName will be amazonRepository which is already present in spring boot
        String repositoryName = productOrigin.toLowerCase()+"Repository";

        if(repositories.containsKey(repositoryName)) {
            repositories.get(repositoryName).save(productDetails);
        } else  {
            logger.error("{} shop is undefined in DB. Check and try again", productOrigin);
            throw new RuntimeException("Shop doesnot exist in MongoDb");
        }



    }

}