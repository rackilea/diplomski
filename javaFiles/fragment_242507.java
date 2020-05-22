added foo
2018-10-31 10:22:58.998  INFO 1768 --- [ask-scheduler-1] foo                                      : processing: foo
2018-10-31 10:23:02.001  INFO 1768 --- [ask-scheduler-1] foo                                      : processing: foo
2018-10-31 10:23:05.002  INFO 1768 --- [ask-scheduler-2] foo                                      : processing: foo
2018-10-31 10:23:07.312  INFO 1768 --- [nio-8080-exec-2] o.s.i.endpoint.EventDrivenConsumer       : Adding {bridge} as a subscriber to the 'bar.channel#1' channel
2018-10-31 10:23:07.312  INFO 1768 --- [nio-8080-exec-2] o.s.integration.channel.DirectChannel    : Channel 'application.bar.channel#1' has 1 subscriber(s).
2018-10-31 10:23:07.312  INFO 1768 --- [nio-8080-exec-2] o.s.i.endpoint.EventDrivenConsumer       : started bar.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
2018-10-31 10:23:07.312  INFO 1768 --- [nio-8080-exec-2] o.s.i.e.SourcePollingChannelAdapter      : started bar.org.springframework.integration.config.SourcePollingChannelAdapterFactoryBean#0
added bar
2018-10-31 10:23:07.312  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: bar
2018-10-31 10:23:08.008  INFO 1768 --- [ask-scheduler-1] foo                                      : processing: foo
2018-10-31 10:23:10.316  INFO 1768 --- [ask-scheduler-2] foo                                      : processing: bar
2018-10-31 10:23:11.009  INFO 1768 --- [ask-scheduler-4] foo                                      : processing: foo
2018-10-31 10:23:13.318  INFO 1768 --- [ask-scheduler-5] foo                                      : processing: bar
2018-10-31 10:23:14.011  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: foo
2018-10-31 10:23:16.322  INFO 1768 --- [ask-scheduler-6] foo                                      : processing: bar
2018-10-31 10:23:16.614  INFO 1768 --- [nio-8080-exec-4] o.s.i.endpoint.EventDrivenConsumer       : Adding {bridge} as a subscriber to the 'baz.channel#1' channel
2018-10-31 10:23:16.614  INFO 1768 --- [nio-8080-exec-4] o.s.integration.channel.DirectChannel    : Channel 'application.baz.channel#1' has 1 subscriber(s).
2018-10-31 10:23:16.614  INFO 1768 --- [nio-8080-exec-4] o.s.i.endpoint.EventDrivenConsumer       : started baz.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
2018-10-31 10:23:16.614  INFO 1768 --- [nio-8080-exec-4] o.s.i.e.SourcePollingChannelAdapter      : started baz.org.springframework.integration.config.SourcePollingChannelAdapterFactoryBean#0
added baz
2018-10-31 10:23:16.614  INFO 1768 --- [ask-scheduler-7] foo                                      : processing: baz
2018-10-31 10:23:17.012  INFO 1768 --- [ask-scheduler-1] foo                                      : processing: foo
2018-10-31 10:23:19.323  INFO 1768 --- [ask-scheduler-2] foo                                      : processing: bar
2018-10-31 10:23:19.615  INFO 1768 --- [ask-scheduler-8] foo                                      : processing: baz
2018-10-31 10:23:20.014  INFO 1768 --- [ask-scheduler-4] foo                                      : processing: foo
2018-10-31 10:23:22.324  INFO 1768 --- [ask-scheduler-9] foo                                      : processing: bar
2018-10-31 10:23:22.622  INFO 1768 --- [ask-scheduler-5] foo                                      : processing: baz
2018-10-31 10:23:23.015  INFO 1768 --- [sk-scheduler-10] foo                                      : processing: foo
2018-10-31 10:23:25.326  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: bar
2018-10-31 10:23:25.623  INFO 1768 --- [ask-scheduler-6] foo                                      : processing: baz
2018-10-31 10:23:26.020  INFO 1768 --- [ask-scheduler-7] foo                                      : processing: foo
2018-10-31 10:23:27.966  INFO 1768 --- [nio-8080-exec-6] o.s.i.e.SourcePollingChannelAdapter      : stopped bar.org.springframework.integration.config.SourcePollingChannelAdapterFactoryBean#0
2018-10-31 10:23:27.966  INFO 1768 --- [nio-8080-exec-6] o.s.i.endpoint.EventDrivenConsumer       : Removing {bridge} as a subscriber to the 'bar.channel#1' channel
2018-10-31 10:23:27.966  INFO 1768 --- [nio-8080-exec-6] o.s.integration.channel.DirectChannel    : Channel 'application.bar.channel#1' has 0 subscriber(s).
2018-10-31 10:23:27.966  INFO 1768 --- [nio-8080-exec-6] o.s.i.endpoint.EventDrivenConsumer       : stopped bar.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
removed bar
2018-10-31 10:23:28.624  INFO 1768 --- [ask-scheduler-1] foo                                      : processing: baz
2018-10-31 10:23:29.025  INFO 1768 --- [ask-scheduler-8] foo                                      : processing: foo
2018-10-31 10:23:31.625  INFO 1768 --- [ask-scheduler-4] foo                                      : processing: baz
2018-10-31 10:23:32.026  INFO 1768 --- [ask-scheduler-9] foo                                      : processing: foo
2018-10-31 10:23:34.626  INFO 1768 --- [ask-scheduler-5] foo                                      : processing: baz
2018-10-31 10:23:35.027  INFO 1768 --- [sk-scheduler-10] foo                                      : processing: foo
2018-10-31 10:23:35.931  INFO 1768 --- [nio-8080-exec-7] o.s.i.e.SourcePollingChannelAdapter      : stopped baz.org.springframework.integration.config.SourcePollingChannelAdapterFactoryBean#0
2018-10-31 10:23:35.931  INFO 1768 --- [nio-8080-exec-7] o.s.i.endpoint.EventDrivenConsumer       : Removing {bridge} as a subscriber to the 'baz.channel#1' channel
2018-10-31 10:23:35.931  INFO 1768 --- [nio-8080-exec-7] o.s.integration.channel.DirectChannel    : Channel 'application.baz.channel#1' has 0 subscriber(s).
2018-10-31 10:23:35.932  INFO 1768 --- [nio-8080-exec-7] o.s.i.endpoint.EventDrivenConsumer       : stopped baz.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
removed baz
2018-10-31 10:23:38.032  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: foo
2018-10-31 10:23:41.036  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: foo
2018-10-31 10:23:44.037  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: foo
2018-10-31 10:23:47.041  INFO 1768 --- [ask-scheduler-3] foo                                      : processing: foo
2018-10-31 10:23:47.736  INFO 1768 --- [nio-8080-exec-9] o.s.i.e.SourcePollingChannelAdapter      : stopped foo.org.springframework.integration.config.SourcePollingChannelAdapterFactoryBean#0
2018-10-31 10:23:47.736  INFO 1768 --- [nio-8080-exec-9] o.s.i.endpoint.EventDrivenConsumer       : Removing {bridge} as a subscriber to the 'foo.channel#1' channel
2018-10-31 10:23:47.736  INFO 1768 --- [nio-8080-exec-9] o.s.integration.channel.DirectChannel    : Channel 'application.foo.channel#1' has 0 subscriber(s).
2018-10-31 10:23:47.736  INFO 1768 --- [nio-8080-exec-9] o.s.i.endpoint.EventDrivenConsumer       : stopped foo.org.springframework.integration.config.ConsumerEndpointFactoryBean#0
removed foo
2018-10-31 10:23:51.349  INFO 1768 --- [on(2)-127.0.0.1] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
2018-10-31 10:23:51.350  INFO 1768 --- [on(2)-127.0.0.1] o.s.i.endpoint.EventDrivenConsumer       : Removing {logging-channel-adapter:_org.springframework.integration.errorLogger} as a subscriber to the 'errorChannel' channel
2018-10-31 10:23:51.350  INFO 1768 --- [on(2)-127.0.0.1] o.s.i.channel.PublishSubscribeChannel    : Channel 'application.errorChannel' has 0 subscriber(s).
2018-10-31 10:23:51.351  INFO 1768 --- [on(2)-127.0.0.1] o.s.i.endpoint.EventDrivenConsumer       : stopped _org.springframework.integration.errorLogger
2018-10-31 10:23:51.351  INFO 1768 --- [on(2)-127.0.0.1] o.s.s.c.ThreadPoolTaskScheduler          : Shutting down ExecutorService 'taskScheduler'
2018-10-31 10:23:51.352  INFO 1768 --- [on(2)-127.0.0.1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'