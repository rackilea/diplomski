> Bean1 starts a read-only tx. 31 09:31:36.418 [pool-1-thread-1] DEBUG
> o.s.orm.jpa.JpaTransactionManager - Creating new transaction with name
> [nz.co.vodafone.wcim.business.Bean1.startSomething]:
> PROPAGATION_REQUIRED,ISOLATION_DEFAULT,readOnly; ''
> 
> Bean2 starts a new read-write tx 31 09:31:36.449 [pool-1-thread-1]
> DEBUG o.s.orm.jpa.JpaTransactionManager - Suspending current
> transaction, creating new transaction with name