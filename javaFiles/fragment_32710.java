void
gtk_list_store_insert (GtkListStore *list_store,
               GtkTreeIter  *iter,
               gint          position)
{
  GtkListStorePrivate *priv;
  GtkTreePath *path;
  GSequence *seq;
  GSequenceIter *ptr;
  gint length;

  g_return_if_fail (GTK_IS_LIST_STORE (list_store));
  g_return_if_fail (iter != NULL);

  priv = list_store->priv;

  priv->columns_dirty = TRUE;

  seq = priv->seq;

  length = g_sequence_get_length (seq);
  if (position > length || position < 0)
    position = length;

  ptr = g_sequence_get_iter_at_pos (seq, position);
  ptr = g_sequence_insert_before (ptr, NULL);

  iter->stamp = priv->stamp;
  iter->user_data = ptr;

  g_assert (iter_is_valid (iter, list_store));

  priv->length++;

  path = gtk_tree_path_new ();
  gtk_tree_path_append_index (path, position);
  gtk_tree_model_row_inserted (GTK_TREE_MODEL (list_store), path, iter);
  gtk_tree_path_free (path);
}