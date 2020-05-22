package com.somepackage.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.yourpackagestructure.Parent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Service
public class Service{

   private MongoTemplate mongoTemplate;

   public Service(MongoTemplate mongoTemplate){
    this.mongoTemplate = mongoTemplate;
   }

   public List<Parent> getParentList(String mapKey){
    Query query = new Query();
    query.addCriteria(Criteria.where("someMap." + mapKey).exists(true));
    List<Parent> parents = mongoTemplate.find(query,Parent.class);
   }
}