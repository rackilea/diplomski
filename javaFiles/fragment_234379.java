package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono


@Component
class LogFilter: WebFilter {

    private val logger = LoggerFactory.getLogger(LogFilter::class.java)

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val startTime = System.currentTimeMillis()
        val request = exchange.request
        val path = request.uri.path

        val requestPrintMap = mutableMapOf<Any, Any>()
        requestPrintMap["headers"] = request.headers
        requestPrintMap["uri"] = request.uri
        requestPrintMap["params"] = request.queryParams

        return chain
                .filter(exchange)
                .doAfterTerminate {

            logger.info("Served '{}' as {} in {} msec",
                    path,
                    exchange.response.statusCode,
                    System.currentTimeMillis() - startTime)
        }
    }

}