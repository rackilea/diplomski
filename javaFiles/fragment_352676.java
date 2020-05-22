create schema PERMISSION_TOOLS;
CREATE ALIAS PERMISSION_TOOLS.GET_ACCESS_LEVEL as $$
String nextPrime(String value) {
    return new BigInteger(value).nextProbablePrime().toString();
}
$$;
select permission_tools.get_access_level(1) from dual;