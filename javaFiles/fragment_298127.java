class MonitorLock {
    JNIEnv *env;
    jobject obj;

public:
    MonitorLock(JNIEnv *in_env, jobject in_obj)
            : env(in_env), obj(in_obj) {
        if (env->MonitorEnter(obj)) {
            // there was an unusual problem,
            // you'll need to decide what to do with it
        }
    }

    ~MonitorLock() {
        if (env->MonitorExit(obj)) {
            // there was an unusual problem,
            // you'll need to decide what to do with it
        }
    }
};