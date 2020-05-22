<!-- tools location -->
<property name="android.tools.dir" location="${sdk.dir}/tools" />
<property name="android.platform.tools.dir" location="${sdk.dir}/platform-tools" />
<property name="android.buildtools.dir" location="${sdk.dir}/build-tools/22.0.1" />
<condition property="exe" value=".exe" else=""><os family="windows" /></condition>
<condition property="bat" value=".bat" else=""><os family="windows" /></condition>
<property name="adb" location="${android.platform.tools.dir}/adb${exe}" />
<property name="lint" location="${android.tools.dir}/lint${bat}" />
<property name="zipalign" location="${android.buildtools.dir}/zipalign${exe}" />
<property name="aidl" location="${android.platform.tools.dir}/aidl${exe}" />
<property name="aapt" location="${android.buildtools.dir}/aapt${exe}" />
<property name="dx" location="${android.buildtools.dir}/dx${bat}" />
<property name="renderscript" location="${android.buildtools.dir}/llvm-rs-cc${exe}"/>
<property name="lint" location="${android.tools.dir}/lint${bat}" />