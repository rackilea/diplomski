import org.springframework.aop.scope.ScopedProxyFactoryBean

beans = {
    cartServiceProxy(ScopedProxyFactoryBean) {
        targetBeanName = 'cartService'
        proxyTargetClass = true
    }
}