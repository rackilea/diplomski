// Prefetch instructions. ...
instruct prefetchr( memory mem ) %{
  predicate(ReadPrefetchInstr==3);
  match(PrefetchRead mem);
  ins_cost(125);

  format %{ "PREFETCHR $mem\t# Prefetch into level 1 cache" %}
  ins_encode %{
    __ prefetchr($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchrNTA( memory mem ) %{
  predicate(ReadPrefetchInstr==0);
  match(PrefetchRead mem);
  ins_cost(125);

  format %{ "PREFETCHNTA $mem\t# Prefetch into non-temporal cache for read" %}
  ins_encode %{
    __ prefetchnta($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchrT0( memory mem ) %{
  predicate(ReadPrefetchInstr==1);
  match(PrefetchRead mem);
  ins_cost(125);

  format %{ "PREFETCHT0 $mem\t# prefetch into L1 and L2 caches for read" %}
  ins_encode %{
    __ prefetcht0($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchrT2( memory mem ) %{
  predicate(ReadPrefetchInstr==2);
  match(PrefetchRead mem);
  ins_cost(125);

  format %{ "PREFETCHT2 $mem\t# prefetch into L2 caches for read" %}
  ins_encode %{
    __ prefetcht2($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchwNTA( memory mem ) %{
  match(PrefetchWrite mem);
  ins_cost(125);

  format %{ "PREFETCHNTA $mem\t# Prefetch to non-temporal cache for write" %}
  ins_encode %{
    __ prefetchnta($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

// Prefetch instructions for allocation.

instruct prefetchAlloc( memory mem ) %{
  predicate(AllocatePrefetchInstr==3);
  match(PrefetchAllocation mem);
  ins_cost(125);

  format %{ "PREFETCHW $mem\t# Prefetch allocation into level 1 cache and mark modified" %}
  ins_encode %{
    __ prefetchw($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchAllocNTA( memory mem ) %{
  predicate(AllocatePrefetchInstr==0);
  match(PrefetchAllocation mem);
  ins_cost(125);

  format %{ "PREFETCHNTA $mem\t# Prefetch allocation to non-temporal cache for write" %}
  ins_encode %{
    __ prefetchnta($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchAllocT0( memory mem ) %{
  predicate(AllocatePrefetchInstr==1);
  match(PrefetchAllocation mem);
  ins_cost(125);

  format %{ "PREFETCHT0 $mem\t# Prefetch allocation to level 1 and 2 caches for write" %}
  ins_encode %{
    __ prefetcht0($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}

instruct prefetchAllocT2( memory mem ) %{
  predicate(AllocatePrefetchInstr==2);
  match(PrefetchAllocation mem);
  ins_cost(125);

  format %{ "PREFETCHT2 $mem\t# Prefetch allocation to level 2 cache for write" %}
  ins_encode %{
    __ prefetcht2($mem$$Address);
  %}
  ins_pipe(ialu_mem);
%}