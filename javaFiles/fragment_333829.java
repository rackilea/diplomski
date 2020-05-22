package com.assec.engine.toolbox.math.matrix;

import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Iterator;

import com.assec.engine.toolbox.ArrayUtils;
import com.assec.engine.toolbox.BufferUtils;
import com.assec.engine.toolbox.math.quaternion.Quaternion;
import com.assec.engine.toolbox.math.vectors.Vector3f;
import com.assec.engine.toolbox.math.vectors.Vector4f;

public class Matrix4f extends Matrix{

    public float m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44;

    public Matrix4f(float m11, float m12, float m13, float m14,
                    float m21, float m22, float m23, float m24,
                    float m31, float m32, float m33, float m34,
                    float m41, float m42, float m43, float m44) {
        super(new Float[] { m11, m12, m13, m14, 
                            m21, m22, m23, m24, 
                            m31, m32, m33, m34, 
                            m41, m42, m43, m44});
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;

    }

    @Override
    public Iterator<Float> iterator() {
        return Arrays.asList(this.toRawTypes()).iterator();
    }

    public Matrix4f invert() {
        Matrix4f matrixOfMinors =   new Matrix4f(   new Matrix3f(   m22, m23, m24,
                                                                    m32, m33, m34,
                                                                    m42, m43, m44).getDeterminant(), new Matrix3f(  m21, m23, m24,
                                                                                                                    m31, m33, m34,
                                                                                                                    m41, m43, m44).getDeterminant(), new Matrix3f(  m21, m22, m24,
                                                                                                                                                                    m31, m32, m34,
                                                                                                                                                                    m41, m42, m44).getDeterminant(), new Matrix3f(  m21, m22, m23,
                                                                                                                                                                                                                    m31, m32, m33,
                                                                                                                                                                                                                    m41, m42, m43).getDeterminant(),
                                                    new Matrix3f(   m12, m13, m14,
                                                                    m32, m33, m34,
                                                                    m42, m43, m44).getDeterminant(), new Matrix3f(  m11, m13, m14,
                                                                                                                    m31, m33, m34,
                                                                                                                    m41, m43, m44).getDeterminant(), new Matrix3f(  m11, m12, m14,
                                                                                                                                                                    m31, m32, m34,
                                                                                                                                                                    m41, m42, m44).getDeterminant(), new Matrix3f(  m11, m12, m23,
                                                                                                                                                                                                                    m31, m32, m33,
                                                                                                                                                                                                                    m41, m42, m43).getDeterminant(),
                                                    new Matrix3f(   m12, m13, m14,
                                                                    m22, m23, m24,
                                                                    m42, m43, m44).getDeterminant(), new Matrix3f(  m11, m13, m14,
                                                                                                                    m21, m23, m24,
                                                                                                                    m41, m43, m44).getDeterminant(), new Matrix3f(  m11, m12, m14,
                                                                                                                                                                    m21, m22, m24,
                                                                                                                                                                    m41, m42, m44).getDeterminant(), new Matrix3f(  m11, m12, m23,
                                                                                                                                                                                                                    m21, m22, m23,
                                                                                                                                                                                                                    m41, m42, m43).getDeterminant(),
                                                    new Matrix3f(   m12, m13, m14,
                                                                    m22, m23, m24,
                                                                    m32, m33, m34).getDeterminant(), new Matrix3f(  m11, m13, m14,
                                                                                                                    m21, m23, m24,
                                                                                                                    m31, m33, m34).getDeterminant(), new Matrix3f(  m11, m12, m14,
                                                                                                                                                                    m21, m22, m24,
                                                                                                                                                                    m31, m32, m34).getDeterminant(), new Matrix3f(  m11, m12, m23,
                                                                                                                                                                                                                    m21, m22, m23,
                                                                                                                                                                                                                    m31, m32, m33).getDeterminant());
        matrixOfMinors.m12 = -m12;
        matrixOfMinors.m14 = -m14;

        matrixOfMinors.m21 = -m21;
        matrixOfMinors.m23 = -m23;

        matrixOfMinors.m32 = -m32;
        matrixOfMinors.m34 = -m34;

        matrixOfMinors.m41 = -m41;
        matrixOfMinors.m43 = -m43;

        float temp = 0;

        temp = matrixOfMinors.m12;
        matrixOfMinors.m12 = matrixOfMinors.m21;
        matrixOfMinors.m21 = temp;

        temp = matrixOfMinors.m13;
        matrixOfMinors.m13= matrixOfMinors.m31;
        matrixOfMinors.m31 = temp;

        temp = matrixOfMinors.m23;
        matrixOfMinors.m23 = matrixOfMinors.m32;
        matrixOfMinors.m32 = temp;

        temp = matrixOfMinors.m14;
        matrixOfMinors.m14 = matrixOfMinors.m41;
        matrixOfMinors.m41 = temp;

        temp = matrixOfMinors.m24;
        matrixOfMinors.m24 = matrixOfMinors.m42;
        matrixOfMinors.m42 = temp;

        temp = matrixOfMinors.m34;
        matrixOfMinors.m34 = matrixOfMinors.m43;
        matrixOfMinors.m43 = temp;

        float d = this.getDeterminant();
        return new Matrix4f(matrixOfMinors.m11/d, matrixOfMinors.m12/d, matrixOfMinors.m13/d, matrixOfMinors.m14/d,
                            matrixOfMinors.m21/d, matrixOfMinors.m22/d, matrixOfMinors.m23/d, matrixOfMinors.m24/d,
                            matrixOfMinors.m31/d, matrixOfMinors.m32/d, matrixOfMinors.m33/d, matrixOfMinors.m34/d,
                            matrixOfMinors.m41/d, matrixOfMinors.m42/d, matrixOfMinors.m43/d, matrixOfMinors.m44/d);
    }

    public float getDeterminant() {
        return  m11*(new Matrix3f(  m22, m23, m24,
                                    m32, m33, m34,
                                    m42, m43, m44).getDeterminant()) - 
                m12*(new Matrix3f(  m21, m23, m24,
                                    m31, m33, m34,
                                    m41, m43, m44).getDeterminant()) + 
                m13*(new Matrix3f(  m21, m22, m24,
                                    m31, m32, m34,
                                    m41, m42, m44).getDeterminant()) - 
                m14*(new Matrix3f(  m21, m22, m23,
                                    m31, m32, m33,
                                    m41, m42, m43).getDeterminant());
    }

    public static Matrix4f identity() {
        return new Matrix4f(1, 0, 0, 0, 
                            0, 1, 0, 0, 
                            0, 0, 1, 0, 
                            0, 0, 0, 1);
    }

    public static Matrix4f perspective(float aspectRatio, float viewAngle, float nearPlane, float farPlane) {
        return new Matrix4f((float) (1/(aspectRatio*Math.tan((viewAngle/2)))),  0,                                      0,                                          0,
                            0,                                                  (float) (1/(Math.tan((viewAngle/2)))),  0,                                          0,
                            0,                                                  0,                                      -((farPlane+nearPlane)/(farPlane-nearPlane)), -(2*farPlane*nearPlane)/(farPlane-nearPlane),
                            0,                                                  0,                                      -1,                                         1);
    }

    public static Matrix4f translation(Vector3f translation) {
        Matrix4f result = Matrix4f.identity();
        result.m14 = translation.x;
        result.m24 = translation.y;
        result.m34 = translation.z;
        return result;
    }

    public static Matrix4f scale(Vector3f scale) {
        Matrix4f result = Matrix4f.identity();
        result.m11 = scale.x;
        result.m22 = scale.y;
        result.m33 = scale.z;
        return result;
    }

    public Matrix4f minus(Matrix4f m) {
        return new Matrix4f(m11-m.m11, m12-m.m12, m13-m.m13, m14-m.m14,
                            m21-m.m21, m22-m.m22, m13-m.m23, m24-m.m24,
                            m31-m.m31, m32-m.m32, m13-m.m33, m34-m.m34,
                            m41-m.m41, m42-m.m42, m13-m.m43, m44-m.m44);
    }

    public Matrix4f plus(Matrix4f m) {
        return new Matrix4f(m11+m.m11, m12+m.m12, m13+m.m13, m14+m.m14,
                            m21+m.m21, m22+m.m22, m13+m.m23, m24+m.m24,
                            m31+m.m31, m32+m.m32, m13+m.m33, m34+m.m34,
                            m41+m.m41, m42+m.m42, m13+m.m43, m44+m.m44);
    }

    public Matrix4f multiply(Matrix4f m) {
        Vector4f r1 = new Vector4f(m11, m12, m13, m14);
        Vector4f r2 = new Vector4f(m21, m22, m23, m24);
        Vector4f r3 = new Vector4f(m31, m32, m33, m34);
        Vector4f r4 = new Vector4f(m41, m42, m43, m44);

        Vector4f c1 = new Vector4f(m.m11, m.m21, m.m31, m.m41);
        Vector4f c2 = new Vector4f(m.m12, m.m22, m.m32, m.m42);
        Vector4f c3 = new Vector4f(m.m13, m.m23, m.m33, m.m43);
        Vector4f c4 = new Vector4f(m.m14, m.m24, m.m34, m.m44);

        return new Matrix4f(r1.dot(c1), r1.dot(c2), r1.dot(c3), r1.dot(c4), 
                            r2.dot(c1), r2.dot(c2), r2.dot(c3), r2.dot(c4),
                            r3.dot(c1), r3.dot(c2), r3.dot(c3), r3.dot(c4),
                            r4.dot(c1), r4.dot(c2), r4.dot(c3), r4.dot(c4));
    }

    public Vector4f multiply(Vector4f v) {
        return new Vector4f(m11*v.x+m12*v.y+m13*v.z+m14*v.w, 
                            m21*v.x+m22*v.y+m23*v.z+m24*v.w, 
                            m31*v.x+m32*v.y+m33*v.z+m34*v.w, 
                            m41*v.x+m42*v.y+m43*v.z+m44*v.w);
    }

    public Matrix4f rotate(float angle, Vector3f axis) {
        Matrix4f rotation = Quaternion.fromEuler(axis.normalized().scaled(angle)).toMatrix();
        return this.multiply(rotation);
    }

    public Matrix4f translate(Vector3f translation) {
        Matrix4f translate = Matrix4f.translation(translation);
        return this.multiply(translate);
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target, Vector3f up) {

        Vector3f direction = eye.minus(target).normalized();    
        Vector3f right = direction.cross(up).normalized();
        Vector3f camUp = right.cross(direction);

        direction = direction.negate();

        Matrix4f viewMatrix = new Matrix4f(
                right.x, right.y, right.z, -right.dot(eye),
                camUp.x, camUp.y, camUp.z, -camUp.dot(eye),
                direction.x, direction.y, direction.z, -direction.dot(eye),
                0.0f, 0.0f, 0.0f, 1.0f);
        return viewMatrix;
    }

    public String toString() {
        return  "" +    this.m11 + " " + this.m12 + " " + this.m13 + " " + this.m14 + "\n" + 
                        this.m21 + " " + this.m22 + " " + this.m23 + " " + this.m24 + "\n" + 
                        this.m31 + " " + this.m32 + " " + this.m33 + " " + this.m34 + "\n" + 
                        this.m41 + " " + this.m42 + " " + this.m43 + " " + this.m44 + "\n";
    }

    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(ArrayUtils.toFloatArray(this.toRawTypes()));
    }
}