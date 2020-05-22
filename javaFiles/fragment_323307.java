use Inline (
    Java       => 'STUDY',
    SHARED_JVM => 1,
    START_JVM  => jvm_is_running() ? 0 : 1,
    STUDY      => ['JavaStuff'],
);