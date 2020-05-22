URI test1 = new URI("http://foo.bar.baz/example%E2%82%AC123");
URI test2 = new URI(test1.getScheme(),
                    test1.getUserInfo(),
                    test1.getHost(),
                    test1.getPort(),
                    test1.getPath(),
                    test1.getQuery(),
                    test1.getFragment());

test2 = new URI(test2.toASCIIString());

assert test1.equals(test2);

System.out.println(test1);
System.out.println(test2);