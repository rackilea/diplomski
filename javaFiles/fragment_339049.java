package com.stackoverflow;

    import java.io.IOException;

    import org.apache.commons.lang.StringUtils;

    public class IgnoreWhiteSpace {

        public static void main(String[] args) throws IOException {


            String search = "abc    cdf   sdf";

            System.out.println(StringUtils.deleteWhitespace(search));

            System.out.print("Found Index :" );

            System.out.println(search.indexOf( 'c' ));

        }

    }