import java.lang.management.ManagementFactory;
import javax.management.ObjectName;
import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.lang.Long;
import javax.management.openmbean.TabularData;
import javax.management.MBeanInfo;

def mBeanServer = ManagementFactory.getPlatformMBeanServer()

def tcpConnectorMBean = new ObjectName("jboss.as:subsystem=resource-adapters,resource-adapter=TCPConnector")
def definitionMBean = new ObjectName( "jboss.as:subsystem=resource-adapters,resource-adapter=TCPConnector,connection-definitions=*" )


println 'before test creation:'
printAvailableBeans(mBeanServer,definitionMBean, 'jndiName')

//createTcpConnection(mBeanServer,tcpConnectorMBean)

//println 'After test creation:'
//printAvailableBeans(mBeanServer,definitionMBean, 'jndiName')

/* 
* After adding a new Connection and configuring the needed properties, the Resource Adapter needs to be (re)activated in order to register
* the newly added connection and make it available with the JNDI
*/
//activateBean(mBeanServer,tcpConnectorMBean)

/**
* This function retrieves the Object for the given name and tries to retrieve all MBeans for it and extracts some information of it.
*/
void printAvailableBeans(def mBeanServer, ObjectName objectName, String attribute){

    mBeanServer.queryMBeans( objectName, null ).each {
        print 'Class name: ' + it.className
        print 'Object name : ' + it.name
        print ' -> '
        def handler = mBeanServer.getAttribute( it.name,attribute )
        println handler
    }

    println ''

}

void createTcpConnection(def mBeanServer,ObjectName objectName){

    final String name = 'TestJMX'
    final Integer allocationRetry = null
    final Long allocationRertyWaitMills = null
    final Boolean backgroundValidation = null
    final Long backgroundValidationMills = null
    final Long blockingTimeoutWaitMills = null
    final String capacityDecrementerClass = null
    final TabularData capacityDecrementerProperties = null
    final String capacityIncrementerClass = null
    final TabularData capacityIncrementerProperties = null
    final String className = 'TCPManagedConnectionFactory'
    final Boolean connectable = false
    final Boolean enabled = true
    final Boolean enlistment = true
    final Boolean enlistmentTrace = null
    final String flushStrategy = 'FailingConnectionOnly'
    final Long idleTimeoutMinutes = null
    final Integer initialPoolSize = null
    final Boolean interleaving = false
    final String jndiName = 'java:/tcp/TestJMX'
    final Integer maxPoolSize = 20
    final String mcp = null
    final Integer minPoolSize = 0
    final Boolean noRecovery = false
    final Boolean noTxSeparatePool = false
    final Boolean padXid = false
    final Boolean poolFair = true
    final Boolean poolPrefill = false
    final Boolean poolUseStrictMin = false
    final String recoveryPassword = null
    final String recoveryPluginClassName = null
    final TabularData recoveryPluginProperties = null
  final String recoverySecurityDomain = null
    final String recoveryUsername = null
    final Boolean sameRmOverride = null
    final Boolean securityApplication = false
    final String securityDomain = null
    final String securityDomainAndApplication = null
    final Boolean sharable = true
    final Boolean tracking = null
    final Boolean useCcm = true
    final Boolean useFastFail = false
    final Boolean useJavaContext = true
    final Boolean validateOnMatch = null
    final Boolean wrapXaResource = true
    final Integer xaResourceTimeout = null


    Object[] opParam =[name,allocationRetry,allocationRertyWaitMills,backgroundValidation,backgroundValidationMills,blockingTimeoutWaitMills,capacityDecrementerClass,capacityDecrementerProperties,capacityIncrementerClass,capacityIncrementerProperties,className,connectable,enabled,enlistment,enlistmentTrace,flushStrategy,idleTimeoutMinutes,initialPoolSize,interleaving,jndiName,maxPoolSize,mcp,minPoolSize,noRecovery,noTxSeparatePool,padXid,poolFair,poolPrefill,poolUseStrictMin,recoveryPassword,recoveryPluginClassName,recoveryPluginProperties,recoverySecurityDomain,recoveryUsername,sameRmOverride,securityApplication,securityDomain,securityDomainAndApplication,sharable,tracking,useCcm,useFastFail,useJavaContext,validateOnMatch,wrapXaResource,xaResourceTimeout]

    String[] opSig = [name.getClass().getName(),allocationRetry.getClass().getName(),allocationRertyWaitMills.getClass().getName(),backgroundValidation.getClass().getName(),backgroundValidationMills.getClass().getName(),blockingTimeoutWaitMills.getClass().getName(),capacityDecrementerClass.getClass().getName(),capacityDecrementerProperties.getClass().getName(),capacityIncrementerClass.getClass().getName(),capacityIncrementerProperties.getClass().getName(),className.getClass().getName(),connectable.getClass().getName(),enabled.getClass().getName(),enlistment.getClass().getName(),enlistmentTrace.getClass().getName(),flushStrategy.getClass().getName(),idleTimeoutMinutes.getClass().getName(),initialPoolSize.getClass().getName(),interleaving.getClass().getName(),jndiName.getClass().getName(),maxPoolSize.getClass().getName(),mcp.getClass().getName(),minPoolSize.getClass().getName(),noRecovery.getClass().getName(),noTxSeparatePool.getClass().getName(),padXid.getClass().getName(),poolFair.getClass().getName(),poolPrefill.getClass().getName(),poolUseStrictMin.getClass().getName(),recoveryPassword.getClass().getName(),recoveryPluginClassName.getClass().getName(),recoveryPluginProperties.getClass().getName(),recoverySecurityDomain.getClass().getName(),recoveryUsername.getClass().getName(),sameRmOverride.getClass().getName(),securityApplication.getClass().getName(),securityDomain.getClass().getName(),securityDomainAndApplication.getClass().getName(),sharable.getClass().getName(),tracking.getClass().getName(),useCcm.getClass().getName(),useFastFail.getClass().getName(),useJavaContext.getClass().getName(),validateOnMatch.getClass().getName(),wrapXaResource.getClass().getName(),xaResourceTimeout.getClass().getName()]

    mBeanServer.invoke(objectName,'addConnectionDefinitions',opParam,opSig)
}

void activateBean(def mBeanServer, ObjectName mBean){
    Object[] opParam = []
    String[] opSig = []

    mBeanServer.invoke(mBean, 'activate', opParam, opSig)
}

return