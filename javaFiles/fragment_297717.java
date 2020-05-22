package com.collegewires.jackson;

import java.util.List;

public class GetEntries{
    private List<Entries> entries;

    public List<Entries> getEntries(){
        return this.entries;
    }
    public void setEntries(List<Entries> entries){
        this.entries = entries;
    }
}