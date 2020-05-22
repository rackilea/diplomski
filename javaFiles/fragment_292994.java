/**
 *
 * @param map workers
 * @param key workers name (class name)
 * @return
 */
public static Provider<ChildWorkerFactory> getWorkerFactoryProviderByKey(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> map, String key) {
    for (Map.Entry<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> entry : map.entrySet()) {
        if (Objects.equals(key, entry.getKey().getName())) {
            return entry.getValue();
        }
    }
    return null;
}