package com.stackoverflow.responses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Dataprovider{
    private Date date;
    private int pendingTickets;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPendingTickets() {
        return pendingTickets;
    }
    public void setPendingTickets(int pendingTickets) {
        this.pendingTickets = pendingTickets;
    }
    public Dataprovider(Date date, int pendingTickets) {
        super();
        this.date = date;
        this.pendingTickets = pendingTickets;
    }
    @Override
    public String toString() {
        return "[ pendingTickets=" + pendingTickets + "]";
    }
}

public class DateSort {

    /*
     * It is to count number of duplicates prevailing in given list
     * */
    public static int getCount(List<Dataprovider> dp,Date date){
        int count = 0;
        for(int i = dp.size()-1;i > -1; i--){
            if(dp.get(i).getDate().compareTo(date) == 0){
                count++;
            }
        }
        return count;
    }
    /*
     * returning list of particular index ie: date*/
    private static List<Dataprovider> getList(Map<Date, List<Dataprovider>> map, Date date) {
        return map.get(date);
    }
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Dataprovider> dataproviders = new ArrayList<Dataprovider>();
        try {
            dataproviders.add(new Dataprovider(dateFormat.parse("2016-01-10"), 1));
            dataproviders.add(new Dataprovider(dateFormat.parse("2016-01-10"), 0));
            dataproviders.add(new Dataprovider(dateFormat.parse("2016-01-09"), 0));
            dataproviders.add(new Dataprovider(dateFormat.parse("2016-01-07"), 1));
            dataproviders.add(new Dataprovider(dateFormat.parse("2016-01-07"), 1));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        /*
         * if you just need the count of duplicates existing 
         * you could just use this result
         * */
        List<Dataprovider> output = dataproviders.stream().filter(n->DateSort.getCount(dataproviders, n.getDate())>1).collect(Collectors.toList());
        System.out.println(output);
        Map<Date,List<Dataprovider>> map = new HashMap<Date,List<Dataprovider>>();
        for(Dataprovider dp : dataproviders){
            /*
             * if map doesn't contain particular date 
             * adding date to map*/
            if(!map.containsKey(dp.getDate())){
                List<Dataprovider> temp = new ArrayList<Dataprovider>();
                temp.add(dp);
                map.put(dp.getDate(), temp);
            }else{
                List<Dataprovider> temp = new ArrayList<Dataprovider>();
                temp.addAll(getList(map,dp.getDate()));
                temp.add(dp);
                map.put(dp.getDate(), temp);
            }
        }
        /*
         * filtering and adding result to another map
         * */
        Map<Date,Dataprovider> outputMap = new HashMap<Date,Dataprovider>();
        for(Date date : map.keySet()){
            if(map.get(date).size()>1){
                int count = 0;
                for(int i = 0; i < map.get(date).size();i++){
                    count = count+map.get(date).get(i).getPendingTickets();
                }
                Dataprovider dataprovider = new Dataprovider(date, count);
                outputMap.put(date, dataprovider);
            }else{
                outputMap.put(date,map.get(date).get(0));
            }
        }
        for(Date date : outputMap.keySet()){
            System.out.println("date :: "+date+" "+outputMap.get(date));
        }
    }
}