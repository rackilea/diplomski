@JmsListener(destination = "foo1", containerFactory="foo1")
public void foo1(final Message jsonMessage) throws JMSException {
...
}

@JmsListener(destination = "foo2", containerFactory="foo2")
public void foo12(final Message jsonMessage) throws JMSException {
...
}