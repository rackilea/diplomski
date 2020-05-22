package com.sample;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.meta.TypeQualifierDefault;

/**
 * This annotation can be applied to a package or class to indicate that the 
 * classes' fields in that element are nonnull by default unless there is
 * <ul>
 *   <li>an explicit nullness annotation
 *   <li>a default field annotation applied to a more tightly nested element.
 * </ul>
 */
@Documented
@Nonnull
@TypeQualifierDefault(ElementType.FIELD)  // <-- METHOD for return values
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsAreNonnullByDefault {
}