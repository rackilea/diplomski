from("timer://my-timer?fixedRate=true&period=20000&delay=0")
  .multicast()
    .to("direct:a", "direct:b", "direct:c")
  .end()

from("direct:a").beanRef("beanA").to("direct:temp")
from("direct:b").beanRef("beanB").to("direct:temp")
from("direct:c").beanRef("beanC").to("direct:temp")

from("direct:temp")
  .filter(new myPredicate())
    .to("myOptionalEndpoint");