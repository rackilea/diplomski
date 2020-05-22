package com.example.android.rs.extremehax;

import android.content.res.Resources;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;

public class HackedScriptC extends ScriptC {

    public HackedScriptC(RenderScript rs, Resources resources, int id) {
        // simple passthru to the only constructor that ScriptC_mono uses
        super(rs, resources, id);
    }

}