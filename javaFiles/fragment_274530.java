package org.example;

/**
 * Created by prahaladd on 08/07/15.
 */
public interface Model<T extends  Identifier>
{
    T getIdentifier();
}