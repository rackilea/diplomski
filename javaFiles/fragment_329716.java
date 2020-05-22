package com.akash.mongo.multidb.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Sample Entity class
 * @author Akash
 *
 */
@Document(collection="productDetails")
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    @Field("productName")
    private String productName;

    @Field("productDesc")
    private String productDesc;

    @Field("productQuantity")
    private String productQuantity;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

}