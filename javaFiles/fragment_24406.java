// android.support.v4.a.a, that is the original obfuscated one
return obfuscated;

// android.support.v4.app._Fragment
return pkgWithDot + '_' + name;

// android.support.v4.app.Fragment_a17d4670
return pkgWithDot + name + '_' + Integer.toHexString(name.hashCode());

// android.support.v4.app.Fragment_a
return pkgWithDot + name + '_' + afterLastDot(obfuscated)

// android.support.v4.app.fRAGMENT
return pkgWithDot + org.apache.commons.lang.StringUtils.swapCase(name);
// needs the following in build.gradle:
buildscript {
    repositories { jcenter() }
    dependencies { classpath 'commons-lang:commons-lang:2.6' }
}

// android.support.v4.app.fragment
return pkgWithDot + name.toLowerCase();