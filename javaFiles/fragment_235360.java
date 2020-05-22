@Configuration
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    prePostEnabled = true,
    proxyTargetClass = true
)
class GlobalSecurityConfiguration : GlobalMethodSecurityConfiguration(){
    override fun accessDecisionManager(): AccessDecisionManager {
        return (super.accessDecisionManager() as AffirmativeBased).apply {
            decisionVoters.replaceAll {
                when(it){
                    is RoleVoter -> MyRoleVoter()
                    else -> it
                }
            }
        }
    }
}