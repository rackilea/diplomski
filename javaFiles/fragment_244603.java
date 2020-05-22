package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.model.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<UserDetails> getUserDetails() {
        Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
        return criteria.list();
    }

}