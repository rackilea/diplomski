Executor executorToUse = this.executor;
if (executorToUse == null) {
    try {
        // Search for TaskExecutor bean... not plain Executor since that would
        // match with ScheduledExecutorService as well, which is unusable for
        // our purposes here. TaskExecutor is more clearly designed for it.
        executorToUse = beanFactory.getBean(TaskExecutor.class);
    }
    catch (NoUniqueBeanDefinitionException ex) {
        try {
            executorToUse = beanFactory.getBean(DEFAULT_TASK_EXECUTOR_BEAN_NAME, TaskExecutor.class);
        }
        catch (NoSuchBeanDefinitionException ex2) {
            throw new IllegalStateException("More than one TaskExecutor bean exists within the context, " +
                    "and none is named 'taskExecutor'. Mark one of them as primary or name it " +
                    "'taskExecutor' (possibly as an alias); or specify the AsyncConfigurer interface " +
                    "and implement getAsyncExecutor() accordingly.", ex);
        }
    }
    catch (NoSuchBeanDefinitionException ex) {
        logger.debug("Could not find default TaskExecutor bean", ex);
        // Giving up -> falling back to default executor within the advisor...
    }
}