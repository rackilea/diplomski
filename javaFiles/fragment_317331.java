Object o = getThis();

if (null == o) {
    log.error("mymethod: Could not retrieve this");
} else {
    o.doThat();
}