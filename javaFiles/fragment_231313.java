//use existing getStateFromMeta
@Override
public int getMetaFromState(IBlockState state) {
    EnumFacing facing = (EnumFacing) state.getValue(FACING);
    return facing == EnumFacing.WEST?0:1;
}