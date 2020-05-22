// foo.h
typedef struct {
  char * bar;
} foo;

foo * foo_new(const char * bar);
void foo_delete(foo * self);

// foo.c
#include <stdlib.h>
#include <string.h>
#include "foo.h"

foo * foo_new(const char * bar) {
  // Allocate foo.
  foo * self = malloc(sizeof(foo));
  if (self == NULL) {
    return NULL;
  }
  memset(self, 0, sizeof(foo));
  // Copy bar to foo.
  size_t bar_len = strlen(bar);
  char * bar_copy = malloc(sizeof(char) * (bar_len + 1));
  if (bar_copy == NULL) {
    foo_delete(self);
    return NULL;
  }
  strncpy(bar_copy, bar, bar_len);
  bar_copy[bar_len] = '\0';
  self->bar = bar_copy;
  // Return foo pointer.
  return self;
}

void foo_delete(foo * self) {
  if (self == NULL) {
    return;
  }
  // Free bar.
  if (self->bar != NULL) {
    free(self->bar);
    self->bar = NULL;
  }
  // Free foo.
  free(self);
}