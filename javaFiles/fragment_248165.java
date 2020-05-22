-> install mvn:com.examples/producer/1.0.1
Bundle ID: 10
-> start 10
-> install mvn:com.examples/consumer/1.0.1     
Bundle ID: 11
-> start 11
DEBUG: WIRE: [11.0] osgi.wiring.package; (&(osgi.wiring.package=com.examples.producer)(version>=1.0.0)(!(version>=2.0.0))) -> [10.0]
Producer bound.
Consumer activate
Aloha.
->