package com.appkart.array;

import java.util.ArrayList;

public class TestCompany {
    ArrayList<Company> companies = new ArrayList<Company>();

    public void addCompany() {
        Company newYorkTimes = new Company("New York Times", "1234",
                "New York", "NY");
        Company nbc = new Company("NBCPhiladelphia", "X123", "Philadelphia",
                "PA");
        Company fox = new Company("FOX News", "0987", "Los Angeles", "LA");

        companies.add(newYorkTimes);
        companies.add(nbc);
        companies.add(fox);

        printCompanyInfo();
    }

    public void addCompanyAtIndex(int index, Company company) {
        companies.add(index, company);

        printCompanyInfo();
    }

    public void printCompanyInfo() {
        for (Company company : companies) {
            System.out.println(company.toString());
        }
    }

    public static void main(String[] args) {
        TestCompany testCompany = new TestCompany();
        testCompany.addCompany();

        Company company = new Company("CNN", "1230", "Atlanta", "GA");
        testCompany.addCompanyAtIndex(1, company);
    }
}