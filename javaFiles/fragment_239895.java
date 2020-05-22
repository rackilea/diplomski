/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KingdomHeart
 */
@ManagedBean
@ViewScoped
public class MyBean {

    private List<String> myList;

    private String selectedResult;

    public MyBean() {
    }

    @PostConstruct
    public void init(){
        myList = new ArrayList<String>();
        myList.add("Test1");
        myList.add("Test2");
        myList.add("Test3");
        myList.add("Test4");
        myList.add("Test5");
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public String getSelectedResult() {
        return selectedResult;
    }

    public void setSelectedResult(String selectedResult) {
        this.selectedResult = selectedResult;
    }    
}