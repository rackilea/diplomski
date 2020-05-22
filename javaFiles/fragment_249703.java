package com.example.bgcolourtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class BgColourTextView extends TextView
{

    private static final float DEFAULT_MAX_CORNER_RADIUS_DIP = 10f;

    private final Paint mPaint;
    private final ArrayList<Path> mOutlines;
    private final float mMaxCornerRadius;

    public BgColourTextView(Context context) {
        this(context, null, 0);
    }

    public BgColourTextView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public BgColourTextView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mOutlines = new ArrayList<>();
        TypedArray ta = context.getTheme().obtainStyledAttributes(attr, R.styleable.BgColourTextView, 0, defStyle);
        try {
            mMaxCornerRadius = ta.getDimension(R.styleable.BgColourTextView_maxCornerRadius,
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_MAX_CORNER_RADIUS_DIP, 
                                          context.getResources().getDisplayMetrics()));
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mOutlines.clear();
        final ArrayList<RectF> lineBounds = new ArrayList<>();
        for (int i = 0; i < getLayout().getLineCount(); i++) {
            RectF rect = new RectF(getLayout().getLineLeft(i), getLayout().getLineTop(i), getLayout().getLineRight(i), getLayout().getLineBottom(i));
            rect.offset(getPaddingLeft(), getPaddingTop());
            rect.inset(-getPaddingLeft() / 2f, 0f);
            lineBounds.add(rect);
        }
        for (int i = 0; i < lineBounds.size(); i++) {
            float rTl = limitRadius(i == 0 ? lineBounds.get(i).width() / 2f : (lineBounds.get(i - 1).left - lineBounds.get(i).left) / 2f);
            float rTr = limitRadius(i == 0 ? lineBounds.get(i).width() / 2f : (lineBounds.get(i).right - lineBounds.get(i - 1).right) / 2f);
            float rBl = limitRadius(i == lineBounds.size() - 1 ? lineBounds.get(i).width() / 2f : (lineBounds.get(i + 1).left - lineBounds.get(i).left) / 2f);
            float rBr = limitRadius(i == lineBounds.size() - 1 ? lineBounds.get(i).width() / 2f : (lineBounds.get(i).right - lineBounds.get(i + 1).right) / 2f);
            mOutlines.add(roundedRect(lineBounds.get(i), rTl, rTr, rBl, rBr));
        }
    }



    @Override
    public void draw(Canvas canvas) {
        for (Path p: mOutlines) {
            canvas.drawPath(p, mPaint);
        }
        super.draw(canvas);
    }   

    /**
     * Limit the corner radius to a maximum absolute value.
     */
    private float limitRadius(float aRadius) {
        return Math.abs(aRadius) < mMaxCornerRadius ? aRadius : mMaxCornerRadius * aRadius / Math.abs(aRadius);
    }

    /**
     * Generate a rectangular path with rounded corners, where a positive corner radius indicates a normal convex corner and
     * negative indicates a concave corner (turning out horizontally rather than round).
     */
    private Path roundedRect(RectF aRect, float rTl, float rTr, float rBl, float rBr) {
        Log.d("BgColourTextView", String.format("roundedRect(%s, %s, %s, %s, %s)", aRect, rTl, rTr, rBl, rBr));
        Path path = new Path();
        path.moveTo(aRect.right, aRect.top + Math.abs(rTr));
        if (rTr > 0) {
            path.arcTo(new RectF(aRect.right - 2 * rTr, aRect.top, aRect.right, aRect.top + 2 * rTr), 0, -90, false);
        } else if (rTr < 0) {
            path.arcTo(new RectF(aRect.right , aRect.top, aRect.right - 2 * rTr, aRect.top - 2 * rTr), 180, 90, false);
        }
        path.lineTo(aRect.left + 2 * Math.abs(rTl), aRect.top);
        if (rTl > 0) {
            path.arcTo(new RectF(aRect.left, aRect.top, aRect.left + 2 * rTl, aRect.top + 2 * rTl), 270, -90, false);
        } else if (rTl < 0) {
            path.arcTo(new RectF(aRect.left + 2 * rTl, aRect.top, aRect.left, aRect.top - 2 * rTl), 270, 90, false);
        } 
        path.lineTo(aRect.left, aRect.bottom - 2 * Math.abs(rBl));
        if (rBl > 0) {
            path.arcTo(new RectF(aRect.left, aRect.bottom - 2 * rBl, aRect.left + 2 * rBl, aRect.bottom), 180, -90, false);
        } else if (rBl < 0) {
            path.arcTo(new RectF(aRect.left + 2 * rBl, aRect.bottom + 2 * rBl, aRect.left, aRect.bottom), 0, 90, false);
        }
        path.lineTo(aRect.right - 2 * Math.abs(rBr), aRect.bottom);
        if (rBr > 0) {
            path.arcTo(new RectF(aRect.right - 2 * rBr, aRect.bottom - 2 * rBr, aRect.right, aRect.bottom), 90, -90, false); 
        } else if (rBr < 0) {
            path.arcTo(new RectF(aRect.right, aRect.bottom + 2 * rBr, aRect.right - 2 * rBr, aRect.bottom), 90, 90, false); 
        }
        path.lineTo(aRect.right, aRect.top + Math.abs(rTr));
        return path;
    }