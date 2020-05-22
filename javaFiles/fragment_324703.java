JavaVM * javaVM;
jobject javaObj;
//different java callback variables
long speechObjId;
std::wstring theString(L"");

std::unique_ptr<CRESpeechLib> pt; //pt now is a global

bool debug;

CRESpeechLib::CRESpeechLib(){
    init(1);
}

CRESpeechLib::CRESpeechLib(int val){
    init(val);
}

CRESpeechLib::~CRESpeechLib(){
    this->isInit = false;
    print("Calling destructor of " + this->id);
    this->ttsInterface.unload();
    this->ttsInterface.getVoicePt()->SetNotifySink(NULL);
}

void CRESpeechLib::init(int val){
    this->isInit = true;
    this->id = val;
    print("Creating Class: " + this->id);
    this->ttsInterface.load();
}

bool CRESpeechLib::say(const std::string &sentence){
    bool balik = this->ttsInterface.say(sentence);
    return balik;
}

void CRESpeechLib::removeNotify(){
    this->ttsInterface.getVoicePt()->SetNotifySink(NULL);
}

ISpVoice* CRESpeechLib::getVoicePointer(){
    return this->ttsInterface.getVoicePt();
}

JNIEXPORT jboolean JNICALL Java_com_example_MainClass_speak(JNIEnv *env, jobject obj, jstring str){
    const char *nativeString = env->GetStringUTFChars(str, FALSE);
    std::string temp(nativeString);
    theString = std::wstring(temp.begin(), temp.end());
    jboolean ret;
    //CRESpeechLib *pt = (CRESpeechLib *) (ptID);

    ret = pt->say(nativeString);

    env->ReleaseStringUTFChars(str, nativeString);

    return ret;
}

JNIEXPORT jobjectArray JNICALL Java_com_example_MainClass_getVoices(JNIEnv *env, jobject thisObj){
    jobjectArray ret;
    //CRESpeechLib *pt = (CRESpeechLib *) (ptID);

    std::vector<std::string> list = pt->getVoices();
    ret = (jobjectArray) env->NewObjectArray(list.size(), env->FindClass("java/lang/String"), env->NewStringUTF(""));

    int i = 0;
    for (std::vector<std::string>::iterator it = list.begin(); it != list.end(); ++it) {
        env->SetObjectArrayElement(ret, i, env->NewStringUTF((*it).c_str()));
        i++;
    }

    return(ret);
}

JNIEXPORT void JNICALL Java_com_example_MainClass_removeNotify(JNIEnv *env, jobject obj){
    //jboolean ret;
    //CRESpeechLib *pt = (CRESpeechLib *) (ptID);

    pt->removeNotify();

    return;
}

JNIEXPORT void JNICALL Java_com_example_MainClass_createTTS(JNIEnv *env, jobject obj, jint id){
    //init variables for the JNI callback

    //CRESpeechLib *pt = new CRESpeechLib(id);
    pt = std::unique_ptr<CRESpeechLib>(new CRESpeechLib(id));
    return;
}


JNIEXPORT void JNICALL Java_com_example_MainClass_deleteTTS(JNIEnv *env, jobject obj){
    print("Delete called");
    pt.release();
    return;
}

void __stdcall outsideeventFunction(WPARAM wParam, LPARAM lParam){
    //event handling of tts
    return;
}

void wordBoundaryCallback(int start, int end) {
    //call java method wordBoundaryCallback
}

HRESULT WaitAndPumpMessagesWithTimeout(HANDLE hWaitHandle, DWORD dwMilliseconds)
{
    //create the pump message
    return hr;
}

////////////////////////////JAVA CODES///////////////////////////////////
//Assume all native codes are already declared
    public MainClass(){
        this.id = 1;
        addressRef = createTTS(id);
        System.out.println("Class reference: " + addressRef);
        this.attachShutDownHook();
    }

    public MainClass(int id){
        this.id = id;
        addressRef = createTTS(id);
        System.out.println("Class reference: " + addressRef);
        this.attachShutDownHook();
    }

    public void wordBoundaryReach(int start, int end){
        System.out.println("From CB: Start: " + start + "\t\tEnd: " + end);
    }


    private void attachShutDownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                MainClass.this.deleteTTS();
                System.out.println("Inside Add Shutdown Hook");
            }
        });
        System.out.println("Shut Down Hook Attached.");
    }

    public static void main(String[] args) {
        MainClass t = new MainClass(1);
        String[] s = (String[])t.getVoices();
        t.setVoice(s[0]);
        if(t.speak("Testing the functionalities from the library. I hope this is fine. Let us try another sentence for the sake of a long speech.")){
            System.out.println("Tapos na. Success");
        }else{
            System.out.println("Tapos na. Failed");
        }
        System.exit(0);
    }