package com.test;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmptyTest {
    @Test
    public void testIsEmpty() {
        List myList = new ArrayList();
        assertThat(myList, is(empty()));

    }
}