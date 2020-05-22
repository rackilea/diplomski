package com.company.business;

import com.company.annotations.RequiredStore;

@RequiredStore
public interface Business {
    @RequiredStore
    public void someMethod();
}