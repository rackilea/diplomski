package com.pipocandobits.maven;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        String source = "ToCountry=US&\n" +
                "ToState=statecode&\n" +
                "SmsMessageSid=smsMessageSid&\n" +
                "NumMedia=0&\n" +
                "ToCity=city&\n" +
                "FromZip=zipCode&\n" +
                "SmsSid=SmsSid&\n" +
                "FromState=statecode&\n" +
                "SmsStatus=received&\n" +
                "FromCity=city&\n" +
                "Body=Hello+it%27s+John+&\n" +
                "FromCountry=US&\n" +
                "To=%2B1toPhoneNumber&\n" +
                "ToZip=55401&\n" +
                "NumSegments=1&\n" +
                "MessageSid=messageSid&\n" +
                "AccountSid=accountSid&\n" +
                "From=%2B1fromPhoneNumber&\n" +
                "ApiVersion=2010-04-01";

        Properties properties = new Properties();
        properties.load(IOUtils.toInputStream(source, "UTF-8"));

        System.out.println("Message body = " + properties.getProperty("Body"));
    }
}